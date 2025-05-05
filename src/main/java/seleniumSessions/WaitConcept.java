package seleniumSessions;

import groovyjarjarantlr4.v4.parse.ANTLRParser.block_return;

public class WaitConcept {

	public static void main(String[] args) {
		
		//WAIT:
			//1.STATIC WAIT: Threadt.sleep(5000)---->not from seleneium, coming from Java
				//E.g: it will wait for 5 seconds, whether the element founf in 2 secs, still the code will freeze for seconds, no matter what
		
			//2.DYNAMIC WAIT: if timeout is 10 sec, and page/element loaded within 2 secs then rest of wait seconds cancelled
				//a.IMPLICITLY WAIT -Function(F)
				//b.EXPLICITLY WAIT
						//i. WebDriverWait -Class(C)
						//ii. FluentWait -Class(C)

	}

}
