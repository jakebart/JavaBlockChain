
public class Block {
	public String currHash;
	public String prevHash;
	private String currData;
	
	public Block(String prevHash, String data) {
		this.prevHash = prevHash;
		this.currData = data;
		HasherDasher h = new HasherDasher(this.prevHash, this.currData);
		this.currHash = h.hash;
		h.mineBlock(); //No blocks will be created as a generic
	}
	
	@Override
	public String toString() {
		return "\n" + this.currData + "\nhash: " + this.currHash + "\nprevious hash: " + this.prevHash + "\n";
	}
	
	

}
