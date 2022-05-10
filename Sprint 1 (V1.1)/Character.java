/**
* Names:  Shairahavan Selvachandran
* Class: ICS4U1-5A
* Date: April 29th, 2022
* Description: Basic Character to be controlled.
*/

public class Character {
   
   private String name;
   private int health;
   private int hunger;
   private int xp;
   private int x;
   private int y;


   public Character (String name, int health, int hunger, int xp, int x, int y){
      this.name = name;
      this.health = health;
      this.hunger = xp;
      this.xp = 0;
      this.x = x;
      this.y = y;
      this.z = 0;
   }

   /*
    Methods
   */
   
   //Accessors
   
   public String getName() {
      return this.name;
   }
   
   public int getHealth() {
      return this.health;
   }
   
   public int getHunger() {
      return this.hunger;
   }
   
   public int getXp() {
      return this.xp;
   }
   
   public int getX() {
      return this.x;
   }
   
   public int getY() {
      return this.y;
   }
   
   public int getZ() {
      return this.z;
   }
   
   //Mutators
    
   public void setName(String newName) {
      this.name = newName;
   }
   
   public void setHealth(int newHealth) {
      this.health = newHealth;
   }
   
   public void setHunger(int newHunger) {
      this.hunger = newHunger;
   }
   
   public void setXp(int newXp) {
      this.xp = newXp;
   }
   
   public void setX(int newX) {
      this.x = newX;
   }
   
   public void setY(int newY) {
      this.y = newY;
   }
   
   public void setZ(int newZ) {
      this.z = newZ;
   }
    
   //Methods

   public void takeDamage(int amount){
      health -= amount;
      if(health <= 0){
         //Death Messages
         System.exit(0);
      }
   }

   public void heal(int amount){
      health =+ amount;
      if(health > MAX_HEALTH){
         health = MAX_HEALTH;
      }
   }

   public void becomeHungry(int amount){
      hunger -= amount;
      if (hunger <= 0){
         hunger = 0;
         //Death messages
         System.exit(0);
      }
   }

   public void eat(Food foodEaten){
      hunger =+ foodEaten.hungerBoost;
      if(hunger > MAX_HUNGER){
         health = MAX_HUNGER;
      }
      
      hunger =+ foodEaten.healthBoost;
      if(hunger > MAX_HEALTH){
         health = MAX_HEALTH;
      }
   }
   
   public void move() {
      //Change x,y,z coordinates
      //Print coordinates
      //Print important info
   }
   
   public void attack(Weapon weaponUsed, Mob npc) {
       
      double distance;
      
      distance = Math.sqrt(Math.pow((this.x-npc.x),2) + Math.pow((this.y-npc.y),2));
      
      if (distance <= weaponUsed.damageRadius){
         npc.health -= weaponUsed.damage;
         if (npc.health <= 0) {
            //mob dies
            System.out.println("You have killed" + npc.name + "!");
         }
      } else {
         System.out.println("Out of range.");
      }
   }
   
   public void farm(Weapon tool, Block block) {
       
      double distance;
      
      // replace with block.x and block.y
      distance = Math.sqrt(Math.pow((this.x-4),2) + Math.pow((this.y-4),2));
       
      if (tool.farmingTool == true){
         if (distance <= tool.damageRadius) {
            // increase inventory
            // check if it exceeds maxStack (return to maxStack if so)
         } else {
            System.out.println("Out of range.");
         }
      } else {
         System.out.println("Inadequate farming tool.");
      }  
   }

   public String toString(){
      String output = "";
      output += "Name: ";
      output += name;
      output += "Health: ";
      output += health;
      output += "\nHunger: ";
      output += hunger;
      output += "\nXP: ";
      output += xp;
      output += "Coordinates: (";
      output += x + ", " + y + ", " + z + ")";
      
      return output;
   }
}
