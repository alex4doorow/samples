public aspect CustomerBo {
    pointcut myPointcut() : execution(* com.sir.richard.boss.bo.CustomerBo.addCustomer(..));

    before() : myPointcut() {
        System.out.println("Before myMethod is called.");
    }

}