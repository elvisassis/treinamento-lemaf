package controllers;

import play.mvc.*;

public class DefautController extends Controller {

	@Before(unless="") //Exemplo basico do uso de @Before para interceptar os requests
    public static void entrada() {
        play.Logger.info("atendendo requisição " + request.contentType);
    }
    
	
	@After //Exemplo basico para o uso de @After para interceptar os responses
    public static void saida() {
		play.Logger.info("devolvendo a requisição " + response.status);	
		
    }

}
