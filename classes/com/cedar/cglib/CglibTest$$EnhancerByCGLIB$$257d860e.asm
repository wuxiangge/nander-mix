// class version 46.0 (46)
// access flags 0x1
public class com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e extends com/cedar/cglib/CglibTest implements net/sf/cglib/proxy/Factory {

  // compiled from: <generated>

  // access flags 0x2
  private Z CGLIB$BOUND

  // access flags 0x9
  public static Ljava/lang/Object; CGLIB$FACTORY_DATA

  // access flags 0x1A
  private final static Ljava/lang/ThreadLocal; CGLIB$THREAD_CALLBACKS

  // access flags 0x1A
  private final static [Lnet/sf/cglib/proxy/Callback; CGLIB$STATIC_CALLBACKS

  // access flags 0x2
  private Lnet/sf/cglib/proxy/MethodInterceptor; CGLIB$CALLBACK_0

  // access flags 0xA
  private static Ljava/lang/Object; CGLIB$CALLBACK_FILTER

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$operate1$0$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$operate1$0$Proxy

  // access flags 0x1A
  private final static [Ljava/lang/Object; CGLIB$emptyArgs

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$equals$1$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$equals$1$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$toString$2$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$toString$2$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$hashCode$3$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$hashCode$3$Proxy

  // access flags 0x1A
  private final static Ljava/lang/reflect/Method; CGLIB$clone$4$Method

  // access flags 0x1A
  private final static Lnet/sf/cglib/proxy/MethodProxy; CGLIB$clone$4$Proxy

  // access flags 0x8
  static CGLIB$STATICHOOK1()V
   FRAME FULL [] []
    NEW java/lang/ThreadLocal
    DUP
    INVOKESPECIAL java/lang/ThreadLocal.<init> ()V
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$THREAD_CALLBACKS : Ljava/lang/ThreadLocal;
    ICONST_0
    ANEWARRAY java/lang/Object
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$emptyArgs : [Ljava/lang/Object;
    LDC "com.cedar.cglib.CglibTest$$EnhancerByCGLIB$$257d860e"
    INVOKESTATIC java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
    ASTORE 0
    ICONST_2
    ANEWARRAY java/lang/String
    DUP
    ICONST_0
    LDC "operate1"
    AASTORE
    DUP
    ICONST_1
    LDC "(Ljava/lang/String;)Ljava/lang/String;"
    AASTORE
    LDC "com.cedar.cglib.CglibTest"
    INVOKESTATIC java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
    DUP
    ASTORE 1
    INVOKEVIRTUAL java/lang/Class.getDeclaredMethods ()[Ljava/lang/reflect/Method;
    INVOKESTATIC net/sf/cglib/core/ReflectUtils.findMethods ([Ljava/lang/String;[Ljava/lang/reflect/Method;)[Ljava/lang/reflect/Method;
    DUP
    ICONST_0
    AALOAD
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$operate1$0$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "(Ljava/lang/String;)Ljava/lang/String;"
    LDC "operate1"
    LDC "CGLIB$operate1$0"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$operate1$0$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    POP
    BIPUSH 8
    ANEWARRAY java/lang/String
    DUP
    ICONST_0
    LDC "equals"
    AASTORE
    DUP
    ICONST_1
    LDC "(Ljava/lang/Object;)Z"
    AASTORE
    DUP
    ICONST_2
    LDC "toString"
    AASTORE
    DUP
    ICONST_3
    LDC "()Ljava/lang/String;"
    AASTORE
    DUP
    ICONST_4
    LDC "hashCode"
    AASTORE
    DUP
    ICONST_5
    LDC "()I"
    AASTORE
    DUP
    BIPUSH 6
    LDC "clone"
    AASTORE
    DUP
    BIPUSH 7
    LDC "()Ljava/lang/Object;"
    AASTORE
    LDC "java.lang.Object"
    INVOKESTATIC java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
    DUP
    ASTORE 1
    INVOKEVIRTUAL java/lang/Class.getDeclaredMethods ()[Ljava/lang/reflect/Method;
    INVOKESTATIC net/sf/cglib/core/ReflectUtils.findMethods ([Ljava/lang/String;[Ljava/lang/reflect/Method;)[Ljava/lang/reflect/Method;
    DUP
    ICONST_0
    AALOAD
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$equals$1$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "(Ljava/lang/Object;)Z"
    LDC "equals"
    LDC "CGLIB$equals$1"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$equals$1$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_1
    AALOAD
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$toString$2$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "()Ljava/lang/String;"
    LDC "toString"
    LDC "CGLIB$toString$2"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$toString$2$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_2
    AALOAD
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$hashCode$3$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "()I"
    LDC "hashCode"
    LDC "CGLIB$hashCode$3"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$hashCode$3$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    DUP
    ICONST_3
    AALOAD
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$clone$4$Method : Ljava/lang/reflect/Method;
    ALOAD 1
    ALOAD 0
    LDC "()Ljava/lang/Object;"
    LDC "clone"
    LDC "CGLIB$clone$4"
    INVOKESTATIC net/sf/cglib/proxy/MethodProxy.create (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sf/cglib/proxy/MethodProxy;
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$clone$4$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    POP
    RETURN
   L0
   FRAME FULL [] [java/lang/Throwable]
    ATHROW
    MAXSTACK = 6
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$operate1$0(Ljava/lang/String;)Ljava/lang/String;
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL com/cedar/cglib/CglibTest.operate1 (Ljava/lang/String;)Ljava/lang/String;
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x11
  public final operate1(Ljava/lang/String;)Ljava/lang/String;
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e java/lang/String] [net/sf/cglib/proxy/MethodInterceptor]
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$operate1$0$Method : Ljava/lang/reflect/Method;
    ICONST_1
    ANEWARRAY java/lang/Object
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$operate1$0$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    CHECKCAST java/lang/String
    ARETURN
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e java/lang/String] [net/sf/cglib/proxy/MethodInterceptor]
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL com/cedar/cglib/CglibTest.operate1 (Ljava/lang/String;)Ljava/lang/String;
    ARETURN
    MAXSTACK = 7
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$equals$1(Ljava/lang/Object;)Z
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL com/cedar/cglib/CglibTest.equals (Ljava/lang/Object;)Z
    IRETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x11
  public final equals(Ljava/lang/Object;)Z
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e java/lang/Object] [net/sf/cglib/proxy/MethodInterceptor]
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$equals$1$Method : Ljava/lang/reflect/Method;
    ICONST_1
    ANEWARRAY java/lang/Object
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$equals$1$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    DUP
    IFNONNULL L2
    POP
    ICONST_0
    GOTO L3
   L2
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e java/lang/Object] [java/lang/Object]
    CHECKCAST java/lang/Boolean
    INVOKEVIRTUAL java/lang/Boolean.booleanValue ()Z
   L3
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e java/lang/Object] [I]
    IRETURN
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e java/lang/Object] [net/sf/cglib/proxy/MethodInterceptor]
    ALOAD 0
    ALOAD 1
    INVOKESPECIAL com/cedar/cglib/CglibTest.equals (Ljava/lang/Object;)Z
    IRETURN
    MAXSTACK = 7
    MAXLOCALS = 2

  // access flags 0x10
  final CGLIB$toString$2()Ljava/lang/String;
    ALOAD 0
    INVOKESPECIAL com/cedar/cglib/CglibTest.toString ()Ljava/lang/String;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x11
  public final toString()Ljava/lang/String;
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [net/sf/cglib/proxy/MethodInterceptor]
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$toString$2$Method : Ljava/lang/reflect/Method;
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$emptyArgs : [Ljava/lang/Object;
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$toString$2$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    CHECKCAST java/lang/String
    ARETURN
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [net/sf/cglib/proxy/MethodInterceptor]
    ALOAD 0
    INVOKESPECIAL com/cedar/cglib/CglibTest.toString ()Ljava/lang/String;
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x10
  final CGLIB$hashCode$3()I
    ALOAD 0
    INVOKESPECIAL com/cedar/cglib/CglibTest.hashCode ()I
    IRETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x11
  public final hashCode()I
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [net/sf/cglib/proxy/MethodInterceptor]
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$hashCode$3$Method : Ljava/lang/reflect/Method;
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$emptyArgs : [Ljava/lang/Object;
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$hashCode$3$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    DUP
    IFNONNULL L2
    POP
    ICONST_0
    GOTO L3
   L2
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [java/lang/Object]
    CHECKCAST java/lang/Number
    INVOKEVIRTUAL java/lang/Number.intValue ()I
   L3
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [I]
    IRETURN
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [net/sf/cglib/proxy/MethodInterceptor]
    ALOAD 0
    INVOKESPECIAL com/cedar/cglib/CglibTest.hashCode ()I
    IRETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x10
  final CGLIB$clone$4()Ljava/lang/Object; throws java/lang/CloneNotSupportedException 
    ALOAD 0
    INVOKESPECIAL com/cedar/cglib/CglibTest.clone ()Ljava/lang/Object;
    ARETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x14
  protected final clone()Ljava/lang/Object; throws java/lang/CloneNotSupportedException 
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    DUP
    IFNONNULL L0
    POP
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [net/sf/cglib/proxy/MethodInterceptor]
    DUP
    IFNULL L1
    ALOAD 0
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$clone$4$Method : Ljava/lang/reflect/Method;
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$emptyArgs : [Ljava/lang/Object;
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$clone$4$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    INVOKEINTERFACE net/sf/cglib/proxy/MethodInterceptor.intercept (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lnet/sf/cglib/proxy/MethodProxy;)Ljava/lang/Object; (itf)
    ARETURN
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [net/sf/cglib/proxy/MethodInterceptor]
    ALOAD 0
    INVOKESPECIAL com/cedar/cglib/CglibTest.clone ()Ljava/lang/Object;
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x9
  public static CGLIB$findMethodProxy(Lnet/sf/cglib/core/Signature;)Lnet/sf/cglib/proxy/MethodProxy;
    ALOAD 0
    INVOKEVIRTUAL java/lang/Object.toString ()Ljava/lang/String;
    DUP
    INVOKEVIRTUAL java/lang/Object.hashCode ()I
    LOOKUPSWITCH
      -508378822: L0
      1458503150: L1
      1826985398: L2
      1913648695: L3
      1984935277: L4
      default: L5
   L0
   FRAME FULL [net/sf/cglib/core/Signature] [java/lang/String]
    LDC "clone()Ljava/lang/Object;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$clone$4$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L1
   FRAME FULL [net/sf/cglib/core/Signature] [java/lang/String]
    LDC "operate1(Ljava/lang/String;)Ljava/lang/String;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$operate1$0$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L2
   FRAME FULL [net/sf/cglib/core/Signature] [java/lang/String]
    LDC "equals(Ljava/lang/Object;)Z"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$equals$1$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L3
   FRAME FULL [net/sf/cglib/core/Signature] [java/lang/String]
    LDC "toString()Ljava/lang/String;"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$toString$2$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L4
   FRAME FULL [net/sf/cglib/core/Signature] [java/lang/String]
    LDC "hashCode()I"
    INVOKEVIRTUAL java/lang/Object.equals (Ljava/lang/Object;)Z
    IFEQ L6
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$hashCode$3$Proxy : Lnet/sf/cglib/proxy/MethodProxy;
    ARETURN
   L5
   FRAME FULL [net/sf/cglib/core/Signature] [java/lang/String]
    POP
   L6
   FRAME FULL [net/sf/cglib/core/Signature] []
    ACONST_NULL
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x1
  public <init>()V
    ALOAD 0
    DUP
    INVOKESPECIAL com/cedar/cglib/CglibTest.<init> ()V
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static CGLIB$SET_THREAD_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$THREAD_CALLBACKS : Ljava/lang/ThreadLocal;
    ALOAD 0
    INVOKEVIRTUAL java/lang/ThreadLocal.set (Ljava/lang/Object;)V
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 1

  // access flags 0x9
  public static CGLIB$SET_STATIC_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V
    ALOAD 0
    PUTSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$STATIC_CALLBACKS : [Lnet/sf/cglib/proxy/Callback;
    RETURN
    MAXSTACK = 1
    MAXLOCALS = 1

  // access flags 0x1A
  private final static CGLIB$BIND_CALLBACKS(Ljava/lang/Object;)V
    ALOAD 0
    CHECKCAST com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e
    ASTORE 1
    ALOAD 1
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BOUND : Z
    IFNE L0
    ALOAD 1
    ICONST_1
    PUTFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BOUND : Z
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$THREAD_CALLBACKS : Ljava/lang/ThreadLocal;
    INVOKEVIRTUAL java/lang/ThreadLocal.get ()Ljava/lang/Object;
    DUP
    IFNONNULL L1
    POP
    GETSTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$STATIC_CALLBACKS : [Lnet/sf/cglib/proxy/Callback;
    DUP
    IFNONNULL L1
    POP
    GOTO L0
   L1
   FRAME FULL [java/lang/Object com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] [java/lang/Object]
    CHECKCAST [Lnet/sf/cglib/proxy/Callback;
    ALOAD 1
    SWAP
    ICONST_0
    AALOAD
    CHECKCAST net/sf/cglib/proxy/MethodInterceptor
    PUTFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
   L0
   FRAME FULL [java/lang/Object com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e] []
    RETURN
    MAXSTACK = 3
    MAXLOCALS = 2

  // access flags 0x1
  public newInstance([Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;
    ALOAD 1
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    NEW com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e
    DUP
    INVOKESPECIAL com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.<init> ()V
    ACONST_NULL
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public newInstance(Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;
    ICONST_1
    ANEWARRAY net/sf/cglib/proxy/Callback
    DUP
    ICONST_0
    ALOAD 1
    AASTORE
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    NEW com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e
    DUP
    INVOKESPECIAL com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.<init> ()V
    ACONST_NULL
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    ARETURN
    MAXSTACK = 4
    MAXLOCALS = 2

  // access flags 0x1
  public newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;
    ALOAD 3
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
   L0
    NEW com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e
    DUP
    ALOAD 1
    DUP
    ARRAYLENGTH
    TABLESWITCH
      0: L1
      default: L2
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [L0 L0 [Ljava/lang/Class;]
    POP
    INVOKESPECIAL com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.<init> ()V
    GOTO L3
   L2
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [L0 L0 [Ljava/lang/Class;]
    GOTO L4
   L4
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [L0 L0 [Ljava/lang/Class;]
    POP
    NEW java/lang/IllegalArgumentException
    DUP
    LDC "Constructor not found"
    INVOKESPECIAL java/lang/IllegalArgumentException.<init> (Ljava/lang/String;)V
    ATHROW
   L3
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e [Ljava/lang/Class; [Ljava/lang/Object; [Lnet/sf/cglib/proxy/Callback;] [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e]
    ACONST_NULL
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$SET_THREAD_CALLBACKS ([Lnet/sf/cglib/proxy/Callback;)V
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 4

  // access flags 0x1
  public getCallback(I)Lnet/sf/cglib/proxy/Callback;
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    ILOAD 1
    TABLESWITCH
      0: L0
      default: L1
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e I] [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e]
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    GOTO L2
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e I] [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e]
    POP
    ACONST_NULL
   L2
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e I] [net/sf/cglib/proxy/MethodInterceptor]
    ARETURN
    MAXSTACK = 2
    MAXLOCALS = 2

  // access flags 0x1
  public setCallback(ILnet/sf/cglib/proxy/Callback;)V
    ILOAD 1
    TABLESWITCH
      0: L0
      default: L1
   L0
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e I net/sf/cglib/proxy/Callback] []
    ALOAD 0
    ALOAD 2
    CHECKCAST net/sf/cglib/proxy/MethodInterceptor
    PUTFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    GOTO L1
   L1
   FRAME FULL [com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e I net/sf/cglib/proxy/Callback] []
    RETURN
    MAXSTACK = 2
    MAXLOCALS = 3

  // access flags 0x1
  public getCallbacks()[Lnet/sf/cglib/proxy/Callback;
    ALOAD 0
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$BIND_CALLBACKS (Ljava/lang/Object;)V
    ALOAD 0
    ICONST_1
    ANEWARRAY net/sf/cglib/proxy/Callback
    DUP
    ICONST_0
    ALOAD 0
    GETFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    AASTORE
    ARETURN
    MAXSTACK = 5
    MAXLOCALS = 1

  // access flags 0x1
  public setCallbacks([Lnet/sf/cglib/proxy/Callback;)V
    ALOAD 0
    ALOAD 1
    DUP2
    ICONST_0
    AALOAD
    CHECKCAST net/sf/cglib/proxy/MethodInterceptor
    PUTFIELD com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$CALLBACK_0 : Lnet/sf/cglib/proxy/MethodInterceptor;
    RETURN
    MAXSTACK = 5
    MAXLOCALS = 2

  // access flags 0x8
  static <clinit>()V
    INVOKESTATIC com/cedar/cglib/CglibTest$$EnhancerByCGLIB$$257d860e.CGLIB$STATICHOOK1 ()V
    RETURN
    MAXSTACK = 0
    MAXLOCALS = 0
}
