int a,b,c,d;
char e;

int soma(int a, int b, int c, int d){
    return (a+b+c+d);
}

int funcao(){
    a = 1;
    b = 2 + 9 * a;
    c = 3;
    d = 4;
    e = 'a'

    return a + b - c * d + soma(a, b, c, d) - e;
}