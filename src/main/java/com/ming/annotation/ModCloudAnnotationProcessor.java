package com.ming.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

//注解处理器会扫描的包名
@SupportedAnnotationTypes("com.ming.注解.*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ModCloudAnnotationProcessor extends AbstractProcessor {
    private Messager messager;
    @Override
    public void init(ProcessingEnvironment processingEnv) {
        //基本构建，主要是初始化一些操作语法树需要的对象
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            return false;
        }
        //获取所有增加了自定义注解的element集合
        Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(HelloWorld.class);
        //遍历这个集合，这个集合的每个element相当于一个拥有自定义注解的需要处理的类。
        set.forEach(System.out::println);
        return true;
    }
}