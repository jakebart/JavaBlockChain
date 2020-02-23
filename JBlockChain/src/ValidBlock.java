import java.util.ArrayList;

//NOTE: 2/23/2020 - Don't use new to create blocks here since new blocks will get mined

public class ValidBlock {
	public ValidBlock() {
		
	}
	public boolean validChain(ArrayList<Block> chain) {
		for (int i = 0; i < chain.size()-1; i++) {
			Block b = chain.get(i);
			Block b1 = chain.get(i+1);
			if (b.currHash != b1.prevHash) {
				return false;
			}
		}
		return true;
	}
	public Block lastValidValue(ArrayList<Block> validLocation) {
		Block ret = null;
		
		for (int i = 0; i < validLocation.size()-1; i++) {
			Block b = validLocation.get(i);
			Block b1 = validLocation.get(i+1);
			
			if (b.currHash != b1.prevHash) {
				return b;
			}
			
			ret = b1;
		}
		return ret;
	}
}
