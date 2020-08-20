### 🌼 java中23种设计模式应用

#### 🍭 面向对象设计原则
   - 1.单一职责原则
        - 单一职责原则是最简单的面向对象设计原则，它用于控制类的粒度大小。
        - 单一职责原则定义如下： 单一职责原则(Single Responsibility Principle, SRP)：一个类只负责一个功能领域中的相应职责，
   - 2.开闭原则
        - 开闭原则是面向对象的可复用设计的第一块基石，它是最重要的面向对象设计原则。
        - 一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展
        - 软件实体可以指一个软件模块、一个由多个类组成的局部结构或一个独立的类。
        - 为了满足开闭原则，需要对系统进行抽象化设计，抽象化是开闭原则的关键。
   - 3.里式代换原则
        - 由2008年图灵奖得主、美国第一位计算机科学女博士Barbara Liskov教授和卡内基·梅隆大学Jeannette Wing教授于1994年提出
        - 简单说就是:所有引用基类（父类）的地方必须能透明地使用其子类的对象。反过来则不一定成立.
        - 里氏代换原则是实现开闭原则的重要方式之一，由于使用基类对象的地方都可以使用子类对象，因此在程序中尽量使用基类类型来对对象进行定义，而在运行时再确定其子类类型，用子类对象来替换父类对象。
        需注意: 
            (1)子类的所有方法必须在父类中声明，或子类必须实现父类中声明的所有方法。
            (2) 我们在运用里氏代换原则时，尽量把父类设计为抽象类或者接口，让子类继承父类或实现父接口，并实现在父类中声明的方法
            
   - 4.依赖倒转原则
        - 如果说开闭原则是面向对象设计的目标的话，那么依赖倒转原则就是面向对象设计的主要实现机制之一，它是系统抽象化的具体实现。
        - 抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对接口编程，而不是针对实现编程。
    
   *注:* 在大多数情况下，以上三个设计原则会同时出现，开闭原则是目标，里氏代换原则是基础，依赖倒转原则是手段，它们相辅相成，相互补充，目标一致，只是分析问题时所站角度不同而已。
    
   - 5.接口隔离原则
       - 接口隔离原则(Interface Segregation Principle, ISP)：使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口。
       - 每一个接口应该承担一种相对独立的角色，不干不该干的事，该干的事都要干。
   
   - 6.合成复用原则
       - 合成复用原则又称为组合/聚合复用原则.
       - 尽量使用对象组合，而不是继承来达到复用的目的。
    
   - 7.迪米特法则
       - 米特法则又称为最少知识原则.
       - 一个软件实体应当尽可能少地与其他实体发生相互作用。
    
#### 设计模式
    
   [🦋 1.代理模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/proxy)

   [🍒 2.工厂模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/factory)
        
   [🌴 3.单例模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/singleton)
    
   [🏄 4.委托模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/delegation)

   [🏇 5.策略模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/strategy)
   
   [🏇 6.原型模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/prototype)
   
   [🍷 7.模板模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/template)
   
   [🎃 8.单例模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/singleton)
   
   [💝 9.装饰者模式](https://github.com/tantaizhijun/javaLearning/tree/master/src/main/java/com/test/DesignPattern23/Decorator)
