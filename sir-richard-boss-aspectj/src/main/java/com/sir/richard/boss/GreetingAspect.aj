public aspect GreetingAspect {

  pointcut greeting() : execution(* com.sir.richard.boss.SirRichardBossAspectjApplication.printName(..));

  before() : greeting() {
     System.out.print("Привет, ");
  }
}