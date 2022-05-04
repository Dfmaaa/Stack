
public class Stack{
	int stackSize=10; //the size of the stack, can be changed anytime, no hardcoded functions that are only prepared for 10(default stack size)
	int[] stack=new int[stackSize]; //the stack
	int top=0; 
	static void push(int value){
	 if(isFull()){  //displays a message saying there's a stack overflow when stack is full
		 System.out.println("Stack overflow."); 
	 }
	 else{
		 stack[top]=value;
		 top++; //increments top, this works like a string/array's length, its real length is top-1, because if you insert the first value, it'll be at stack[0] but top will be 1 after insertion, so the only accessible value will be stack[0] even though top is 1
		 System.out.println("Value number "+ top+ " added successfully");
	 }
	}
	boolean isFull(){
		return top>=stackSize-1; //max real length of this stack is 9 in integers, so if top is bigger or equal to stackSize-1(real), it returns true, if not, false
	}
	static void pop(){ //decreases stack virtual length by 1
		top<=0 ? System.out.println("Stack has no values.") : top--; //this statement only decreases top if it's bigger than 0, if not, it displays a message that says that the stack has no values
	}
	static void moveByOneRight(int start){ //function used by endToStart() to push all the values to right by 1
	  int end=top-1; //this is where virtual length is used if you were wondering, the function wont access the values after top
	  while(end!=start-1){
		  stack[end+1]=stack[end];
		  end--;
	  }
	}
	static void endToStart(){ //this function moves the last value to the first value, then pushes all the values to the right by 1
		if(top>1){
		int saveFirst=stack[0];
		stack[0]=stack[top-1];
		moveByOneRight(1);
		stack[1]=saveFirst;
	   }
	}
	static moveByOneLeft(int start){ //the function used to push values to left by startToEnd()
		int end=1;
		while(end!=start+1){
			stack[end-1]=stack[end];
			end++;
		}
	}
	static boolean isEmpty(){
		return top==0; //if top is zero, it will return true, if not, false
	}
	static void makeEmpty(){
	  top=0; // assigns the default value	
    }
	static void startToEnd(){ //this function moves the first value to the end value and then kind of pushes all the values to the left by 1
		if(top>1){
		int saveEnd=stack[top-1];
		stack[top-1]=stack[0];
		moveByOneLeft(top-2);
		stack[top-2]=saveEnd;
	    }
	}
	static void displayStack(){ //function to display all the values in stack.
		for(int x=0;x<top;x++){
			System.out.println(stack[x]);
		}
	}
	//SOME TRICKS I USED TO VISUALIZE THE STACK:
	// ALWAYS PREPARE FOR THE WORST CASE, THE OTHERS WILL TAKE CARE OF THEMSELVES T
	//THINK WHAT WILL HAPPEN IF THE STACK ONLY HAS 2 VALUES 
	//I ALSO USED BLENDER TO DRAW THE STACK AND DRAW THE STEPS OF THE PUSHING LEFT/RIGHT FUNCTIONS.
	// THE MOVING ALGO EXPLAINED HERE:
      // I FIRST STORED THE FIRST VALUE IN A VARIABLE OUTSIDE THE STACK, THEN ASSIGNED THE LAST VALUE TO THE FIRST VALUE, THEN PUSHED ALL THE VALUES TO RIGHT AFTER 0 BY 1, THEN WE GET AN EMPTY SPACE IN STACK[1] THEN STORE THE PREVIOUS FIRST VALUE IN IT. DO THE REVERSE OF THAT IN LEFT ALGO, WE DON'T EVEN NEED STACK SIZE HERE, BECAUSE WE'RE GONNA STOP AT 0, I DON'T KNOW WHY BUT THE LEFT ALGO WAS HARDER TO VISUALIZE EVEN THOUGH IT'S ALMOST THE SAME AS THE RIGHT ALGO.
    //DON'T WORRY ABOUT VALUES AFTER TOP-1 IF YOU LOOKED AT THE POP FUNCTION, THE BEAUTIFUL THING IS THAT THE FUTURE VALUES WILL REPLACE THEM IF THE ADD FUNCTION IS USED.   
	public static void main (String[] args) {
		//TODO: Implement driver
	}
}

