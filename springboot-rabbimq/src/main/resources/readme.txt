本demo示例为springboot+rabbitmq

基本操作：
一对一：
一对多：消息会交替发送到多个消息消费者上  ， 也就是平均分发到每个receiver上
        **OneToManyReceiver2**: 消息提供者第5发送消息
        **OneToManyReceiver1**: 消息提供者第6发送消息
        **OneToManyReceiver2**: 消息提供者第7发送消息
        **OneToManyReceiver1**: 消息提供者第8发送消息
        **OneToManyReceiver2**: 消息提供者第9发送消息
        **OneToManyReceiver1**: 消息提供者第10发送消息

多对多：当提供者跟消费者数量一致时消息会均匀发送到多个消费者上,
        **--OneToManyReceiver1--**: --$ManyToManySender1$--:消息提供者第3发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender2$--:消息提供者第3发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender1$--:消息提供者第4发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender2$--:消息提供者第4发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender2$--:消息提供者第5发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender1$--:消息提供者第5发送消息

       当不一致时同一对多一样,在对待多的那个提供者的消费上会采用交替方式发送
        **--OneToManyReceiver1--**: --$ManyToManySender1$--:消息提供者第5发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender2$--:消息提供者第5发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender3$--:消息提供者第5发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender1$--:消息提供者第6发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender2$--:消息提供者第6发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender3$--:消息提供者第6发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender1$--:消息提供者第7发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender2$--:消息提供者第7发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender3$--:消息提供者第7发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender1$--:消息提供者第8发送消息
        **--OneToManyReceiver2--**: --$ManyToManySender3$--:消息提供者第8发送消息
        **--OneToManyReceiver1--**: --$ManyToManySender2$--:消息提供者第8发送消息

topic:主题匹配交换机
    #为通配符匹配多个单词或者0个，*只能匹配一个单词
    从sender开始看：
    send1()发送一条消息，routhingkey=topic.message , 到名为"exchange"的交换机(Exchange)中,该交换机对应俩个队列
    A_QUEUE , B_QUEUE,其中A_QUEUE的routhingkey为 "topic.message" , B_QUEUE的routhingkey为 "topic.#"因此,该交换机对应的俩个队列
    都能收到sec1()所发送的消息

    send2()发送一条消息，routhingkey=topic.# , 到名为"exchange"的交换机(Exchange)中,该交换机对应俩个队列
    A_QUEUE , B_QUEUE,其中A_QUEUE的routhingkey为 "topic.message" , B_QUEUE的routhingkey为 "topic.#"因此,该交换机只有B_QUEUE队列能与之匹配
    所以只有B_QUEUE这个队列能收到sec2()所发送的消息

fanout:分发/订阅交换机
    存在A,B,C三个队列,绑定在名为"fanout.exchange" ， 类型为fanout exchange类型的交换机上,当向这个交换机发送消息时,交换机就会把这个消息
    分发给与之相订阅、绑定的队列中,  因此三个对应A,B,C队列的消费者就都接收到了信息
    Body:'User{userName='北凉', passWord='徐凤年'}'
    Body:'User{userName='北凉', passWord='徐凤年'}'
    Body:'User{userName='北凉', passWord='徐凤年'}'
