package primary.coursethree.selfcode;

import class_03.Code_04_DogCatQueue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() { super("dog"); }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    // 需要一个类，可以存放两个成员变量，一个是pet，另一个是count信息存放编号
    public static class PetEnterQueue{
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet1,long count1){
            this.pet = pet1;
            this.count = count1;
        }

        public Pet getType(){   // 静态变量先创建
            return this.pet;
        }

        public long getCount(){
            return this.count;
        }
    }

    public static class DogCat_Queue{
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private long count;

        public DogCat_Queue(){
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet){
            if(pet.getPetType() == "dog"){
                dogQueue.add(new PetEnterQueue(pet,count++));
            }else{
                catQueue.add(new PetEnterQueue(pet,count++));
            }
        }

        public Pet pollAll(){
            if(!dogQueue.isEmpty()&&!catQueue.isEmpty()){
                if(dogQueue.peek().getCount() < catQueue.peek().getCount()){
                    return dogQueue.poll().getType();
                }else{
                    return catQueue.poll().getType();
                }
            }else if(!dogQueue.isEmpty()){
                return dogQueue.poll().getType();
            }else if(!catQueue.isEmpty()){
                return catQueue.poll().getType();
            }else{
                throw new RuntimeException("The DogCatQueue is empty");
            }
        }

        public Pet pollDog(){
            if(dogQueue.isEmpty()){
                throw new RuntimeException("There is no dog");
            }else{
                return dogQueue.poll().getType();
            }
        }

        public Pet pollCat(){
            if(catQueue.isEmpty()){
                throw new RuntimeException("There is no cat");
            }else{
                return catQueue.poll().getType();
            }
        }

        public boolean isEmpty(){
            return dogQueue.isEmpty()&&catQueue.isEmpty();
        }

        public boolean isDogEmpty(){
            return dogQueue.isEmpty();
        }

        public boolean isCatEmpty(){
            return catQueue.isEmpty();
        }

    }


    public static void main(String[] args) {
//        Pet pet = new Pet("Dog");
//        Pet pet1 = new Dog();
//        Pet pet2 = new Cat();
//        System.out.println(pet.getPetType());  //Dog
//        System.out.println(pet1.getPetType()); //dog
//        System.out.println(pet2.getPetType());  //cat
//
//        System.out.println("==============================");

        Pet pet1 = new Dog();
        Pet pet2 = new Cat();
        Pet pet3 = new Cat();
        Pet pet4 = new Dog();

        DogCat_Queue petQueue = new DogCat_Queue();
        System.out.println(petQueue.isEmpty());  // true
        petQueue.add(pet1);
        System.out.println(petQueue.isEmpty());  // false
        System.out.println(petQueue.isCatEmpty()); // true

        petQueue.add(pet2);
        petQueue.add(pet3);
        petQueue.add(pet4);
        System.out.println(petQueue.pollAll().getPetType()); // dog
        System.out.println(petQueue.pollCat().getPetType()); // cat
        System.out.println(petQueue.pollDog().getPetType()); // dog
//        System.out.println(petQueue.pollDog().getPetType()); // there is no dog

    }
}
