module spring.jpms.demo {
    requires spring.core;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires static lombok;
    exports com.example.springjpmsdemo;
//    opens com.example.springjpmsdemo
//      to spring.core, spring.beans, spring.context;
}