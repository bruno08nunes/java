X x = new X();  // Instancia objeto X
A a = new A();  // Instancia objeto A
B b = new B();  // Instancia objeto B

x.m1();         // chama m1() de X
a.m1();         // chama m1() de A
b.m1();         // chama m1() de B

a.m2();         // chama m2() de A
b.m2();         // Dá um erro pois não existe

b.m3();         // chama m3() de X no objeto B

B bb;           // apenas declara uma referência do tipo B
bb.m3();        // Dá um erro pois a variável bb não foi inicializada
bb = b;         // bb passa a apontar para o mesmo objeto que b
bb.m3();        // chama m3() de X no objeto B

a.m4();         // Dá um erro pois não existe

public class Animal {
    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }
}

public class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }
}
