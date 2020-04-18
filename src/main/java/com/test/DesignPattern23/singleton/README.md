### 🌲 单例模式
    
    保证从系统启动到系统停止, 整个系统运行过程只会产生一个实例
    
    - 1.为什么用单例模式
        当我们在应用中遇到功能性冲突的时候, 需要使用单例模式, 因为出现两份实例就不知道选择谁,就会出问题
        如: spring的context上下文对象
        如: 配置文件
    
    - 2. 单例模式的具体实现
         
         单例模式的几种写法


### 单例失效的情况
 
 1.反射机制的引入来破坏单例模式
```java
public class Singleton {
    public static final Singleton INSTANCE = new Singleton();
    private Singleton() {
    }
    public Singleton getInstance() {
        return INSTANCE;
    }
    public static void main(String[] args) throws Exception {
        // 反射机制破坏单例模式
        Class clazz = Singleton.class;
  //获得构造器
        Constructor c = clazz.getDeclaredConstructor();
        // 反射机制使得private方法可以被访问
        c.setAccessible(true);
        // 判断反射生成的对象与单例对象是否相等
        System.out.println(Singleton.INSTANCE == c.newInstance());
    }
}

```
 
 2.序列化机制来破坏单例模式
```java
public class Singleton implements Serializable {
    public static final Singleton INSTANCE = new Singleton();
    private Singleton() {
    }
    public static void main(String[] args) throws Exception {
        // 支持java.io.Serializable的对象都可以写入流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(Singleton.INSTANCE);
        // 根据字节流生成对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Singleton newSingleton = (Singleton) ois.readObject();
        System.out.println(newSingleton == Singleton.INSTANCE);
    }
}

```

### 防止序列化破坏单利模式

##### 1.防止序列化破坏
```java
private Object readResolve(){
    return instance;
}
```

一般来说，一个类实现了 Serializable接口，我们就可以把它往内存里写再从内存里读出而"组装"成一个跟原来一模一样的对象
当JVM从内存中反序列化地"组装"一个新对象时，就会自动调用这个 readResolve方法来返回我们指定好的对象了，单例规则也就得到了保证

##### 2.防止反射破坏
修改构造器，让它在被要求创建第二个实例的时候抛出异常。
```java
package com.effective.singleton;
public class ElvisModified{
    private static boolean flag = false;        //增加flag
    private ElvisModified(){
        synchronized(ElvisModified.class){
            if(flag == false) {             //增加flag判断
                flag = !flag;               //第一次实例化后修改它
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }
    private  static class SingletonHolder{
        private static final ElvisModified INSTANCE = new ElvisModified();
    }
    public static ElvisModified getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public void doSomethingElse(){
    }
}

```
