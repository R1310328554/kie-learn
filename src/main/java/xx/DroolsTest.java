package xx;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {

	protected KieServices kieServices;
	protected KieContainer kieContainer;

	public void setUp() {
		kieServices = KieServices.Factory.get();
		kieContainer = kieServices.getKieClasspathContainer();
	}

	public static void main(String[] args) {
		DroolsTest droolsTest = new DroolsTest();
		droolsTest.setUp();
		droolsTest.test();
	}

	private void test() {

		KieSession kSession = kieContainer.newKieSession("ksession-rules");
		Message message = new Message();
		message.setMessage("Hello World");
		message.setStatus(Message.HELLO);
		kSession.insert(message);
		kSession.fireAllRules();

	}
}