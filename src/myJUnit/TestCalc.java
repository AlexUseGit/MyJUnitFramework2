package myJUnit;

public class TestCalc extends MyTestCase{
	
	int x;
	int y;
	
	@Override
	public void setUp(){
		x = 3;
		y = 4;
	}
	
	public void testPlus(){
		assert(7 == Calc.plus(x, y));
	}

}
