
import javax.script.*;
import java.io.*;
import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;


public class test {
	
	public static void main(String[] args) throws Exception {
		
		ScriptEngineManager sem = new ScriptEngineManager();
		List<ScriptEngineFactory> factories = sem.getEngineFactories();
		for (ScriptEngineFactory factory : factories)
		    System.out.println(factory.getEngineName() + " " + factory.getEngineVersion() + " " + factory.getNames());
		if (factories.isEmpty())
		    System.out.println("No Script Engines found");
		
		
		
	    ScriptEngineManager factory = new ScriptEngineManager();
	    ScriptEngine engine = factory.getEngineByName("nashorn"); 
	    engine.eval("print('Hello, World!');");
		
		File file = new File("src/main/javascript");
		for(String fileNames : file.list()) System.out.println(fileNames);
		
		ScriptEngine ee = new ScriptEngineManager().getEngineByName("nashorn");
		
		
		ee.eval(new FileReader("src/main/javascript/account.js"));
		
		System.out.println(ee);
		Invocable invocable = (Invocable)ee;
		
		invocable.invokeFunction("function"); 
	}
}