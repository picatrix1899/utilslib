package tests.tools;


public interface IUnitTest
{
	public abstract boolean test();
	
	public abstract TimingResult stressTestA();
	public abstract TimingResult stressTestB();
	public abstract TimingResult stressTestC();
}
