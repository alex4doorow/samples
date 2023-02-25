package com.skillfactory.modules.java.core.m11.t45;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        try {

            if (i > 1) {
                throw new C();
            } else if (i > 2) {
                throw new D();
            } else if (i > 3) {
                throw new G();
            } else if (i > 4) {
                throw new H();
            }




        } //catch(C e){}catch(D e){} catch(H e){}catch(A e){}
        //catch(C e){}catch(D e){}catch(E e){}catch(A e){}
        //catch(C e){}catch(D e){}catch(G e){}catch(A e){}
        //catch(A e){}catch(D e){}catch(G e){}catch(H e){}
        catch(E e){}catch(D e){}catch(B e){}catch(A e){}

    }
}
