/**
 * Navin Abichandani
 * Homework #3
 * Recitation 01
 * Recitation TA: Charles Chen 
 * Grading TA: Shilpi Bhattacharyya 
 */
package project3;
import java.util.ArrayList;

/**
 *This class is responsible for creating the JSS stack.
 */
public class JSStack extends ArrayList{
/**
 * pushes b onto the front of the backing data structure.
 * @param b the BlockType that is pushed in the stack.
 */
	public void push(BlockType b){
		super.add(b);
	}
/**
 * takes the BlockType that is on top of the backing data structure, saves that
 * value, removes that BlockType from the backing data structure, and returns
 * that BlockType
 * @return the blockType that was removed.
 * @throws EmptyStackException if the stack is empty
 */
	public BlockType pop() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException("Stack is empty.");
		}
		else{
		return (BlockType) super.remove(super.size() - 1);
		}
	}
/**
 * Returns the top value of the stack without deleting it.
 * @return the top value of the stack.
 */
	public BlockType peek(){
		BlockType var = null;
		if(super.size() != 0){
			var =  (BlockType) super.get(super.size() - 1);
		}
		return var;
	}
/**
 * Returns the boolean of whether the stack is empty.	
 */
	public boolean isEmpty(){
		return super.isEmpty();
	}

}
