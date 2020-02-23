import java.util.*;


public class StoreBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Block> chain = new ArrayList<Block>();
		ValidBlock valid = new ValidBlock();
		
		chain.add(new Block("0", "gensis"));
		
		chain.add(new Block(chain.get(0).currHash, "some data"));
		chain.add(new Block(chain.get(1).currHash, "more data!!!11!!1!!"));
		chain.add(new Block(chain.get(2).currHash, "even more data lmao"));
		System.out.println("Our chain is valid: " + valid.validChain(chain));
		System.out.println(chain.toString());
		System.out.println("\nLet's try changing the chain now and see what happens \n");
		//chain.remove(2);
		chain.add(2, new Block(chain.get(3).currHash, "hehehe i'm bad"));
		System.out.println("Our chain is valid: " + valid.validChain(chain));
		if (!valid.validChain(chain)) {
			System.out.println("\nBad block: " + chain.get(chain.lastIndexOf(valid.lastValidValue(chain))+1).toString());
			chain.subList(chain.lastIndexOf(valid.lastValidValue(chain))+1, chain.size()).clear();
			
		}
		
		System.out.println("Now finally after \"prunning\":\nOur chain is valid: " + valid.validChain(chain));
		//System.out.println(valid.validChain(chain));
		
		System.out.println(chain.toString());
	}
	
	
	
}
