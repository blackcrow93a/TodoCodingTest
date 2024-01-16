public class MyHash {

    public Slot[] hashTable;

    public MyHash(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;
        Slot(String key, String value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Divison 기법 ★

    public Integer hashFunction(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key , String value){
        Integer address = this.hashFunction(key);
        if(this.hashTable[address] != null ){

            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];

            while(findSlot != null){
                if(findSlot.key  == key){
                    findSlot.value = value;
                    return true;
                }else{
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key,value);
        }else{
            this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunction(key);
        if(this.hashTable[address] != null){
            Slot findSlot = this.hashTable[address];
            while(findSlot !=null){
                if(findSlot.key == key){
                    return findSlot.value;
                }else{
                    findSlot = findSlot.next;
                }
            }
            return null;
        }else{
           return null;
        }
    }

    public static void main(String[] args) {

        MyHash myhash = new MyHash(20);

        myhash.saveData("sooyoung","010-1111-1111");
        myhash.saveData("fun-coding","010-3333-3333");
        myhash.saveData("fun-cod","010-4444-3333");
        myhash.saveData("fun-codin","010-6666-3333");

        System.out.println(myhash.getData("fun-coding"));
        System.out.println(myhash.getData("fun-cod"));
        System.out.println(myhash.getData("fun-codin"));

    }


}
