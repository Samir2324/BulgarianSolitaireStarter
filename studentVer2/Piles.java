import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 * A class that plays Bulgarian Solitare.
 * Version 3: Complete the isDone method.
*/
public class Piles
{
  
   /**
  	Checks whether the game is done.
  	@return true when the piles have size
  	1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order.
   */
   public boolean isDone()
   {
  	/*
     	We are done when we have some combination of the numbers
     	1 through 9 in the piles. Therefore, we can first check to
     	make sure we have exactly 9 piles so we don't waste our time.
     	We also need to take care that we have the exact numbers and
     	avoid a situation like  1 1 3 4 5 6 7 8 10  which means we
     	still aren't done.
  	*/
 	Collections.sort(piles); //sorts arraylist
  	if (piles.size()==9){ //checks to see if arraylist has 9 piles
        	if (piles.get(0)==1 && piles.get(1)==2 && piles.get(2)==3 && piles.get(3)==4 && piles.get(4)==5 && piles.get(5)==6 && piles.get(6)==7 && piles.get(7)==8 && piles.get(8)==9)
            	//checks that piles follow order
            	return true;
	}
  	return false;

   }
   private ArrayList<Integer> piles;
   /**
  	Sets up the game randomly with some number of piles of random
  	size. The pile sizes add up to 45.
   */
   public Piles(Random generator)
   {
  	piles = new ArrayList<Integer>();
  	/* randomly divide up the deck into piles */
  	int TOTAL_SIZE = 45;  // number of cards in a deck
  	int numCards = TOTAL_SIZE;
  	while (numCards > 0)
  	{
     	int pile = generator.nextInt(numCards) + 1;
     	piles.add(pile);
     	numCards -= pile;
  	}
   }
   /**
  	Set up a pile with a known (non-random) configuration for testing.
  	@param piless an array of numbers whose sum is 45
   */
   public Piles(int[] piless)
   {
  	piles = new ArrayList<>();
  	for (int s : piless)
     	piles.add(s);
   }
   /**
	* Return the string representation of the piles.
	* @return the string representation of the piles.
	*/
   public String toString()
   {
  	return piles.toString();
   }
   /**
  	Play one round of the game.
   */
   public void playRound()
   {
       	piles.add(0); //adds an empty pile each round, which will be added to
  	for (int i=0; i<piles.size(); i++)
  	{
      	if (piles.get(i)==1){ //removes list if it is equal to 1, and sets i appropriately
        	piles.remove(i);
        	i=i-1;}
      	else if (piles.get(i)>1) //sets the pile to one less than original
        	piles.set(i, piles.get(i)-1);
      	//each pile adds 1 to last pile
      	piles.set(piles.size()-1, piles.get(piles.size()-1)+1);
   }
   System.out.println(piles);
   }
}

