package estudo.funcional;

public class Main {
    public static void main(String[] args) {

        //implementacao via classe anonima
        Calculadora soma = new Calculadora() {
            @Override
            public int calcular(int x, int y) {
                return x + y;
            }
        };

        //expressao lambda
        soma = (x,y) -> x + y;

        System.out.println(soma.calcular(1,2));

        Calculadora subtracao = (num, num2) -> num - num2;

        System.out.println("Subtração:");
        System.out.println(subtracao.calcular(20,10));

        Calculadora calc = (y,x)-> {
            var valor = y * 2;
            return valor + x;
        };

        Executor executor = y -> subtracao.calcular(50,10);
        executor.executa(50);
    }
}
