package design_patterns.homework.reflect;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

//生命周期，RunTime = 编译成字节码期间和在内存中运行期间
@Retention(RUNTIME)
//作用范围，METHOD = 允许标注在方法上面
@Target(METHOD)
public @interface Test {

}
