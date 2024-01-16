public class MyHashRe {

    public Slot[] hashTable;

    public MyHashRe(Integer size){
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        //Slot next;
        Slot(String key , String value){
            this.key = key;
            this.value = value;
            //this.next = null;
        }
    }

    public int hashFunc(String key){
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key , String value){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] !=null){

            // Chaning 기법 - 개방해싱 또는 Open Hashing
//            Slot findSlot = this.hashTable[address];
//            Slot prevSlot = this.hashTable[address];
//            while (findSlot !=null){
//                if(findSlot.key == key){
//                    findSlot.value = value;
//                    return true;
//                }else{
//                    prevSlot = findSlot;
//                    findSlot = findSlot.next;
//                }
//            }
//            prevSlot.next = new Slot(key,value);

            //  폐쇄해싱 OR Close Hashing
            if(this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            }else{
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] !=null){
                    if(this.hashTable[currAddress].key == key){
                        this.hashTable[currAddress].value = value;
                        return true;
                    }else{
                        currAddress++;
                        if(currAddress >= this.hashTable.length){
                            return false;
                        }
                    }
                }
                this.hashTable[currAddress] = new Slot(key,value);
                return true;
            }
        }else{
            this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }

    public String getData(String key){
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] !=null){

            if(this.hashTable[address].key == key){
                return this.hashTable[address].value;
            }else{
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] !=null){
                    if(this.hashTable[currAddress].key == key){
                        return this.hashTable[currAddress].value;
                    }else{
                        currAddress++;
                        if(currAddress >= this.hashTable.length){
                            return null;
                        }
                    }
                }
                return null;
            }

//            Slot findSlot = this.hashTable[address];
//
//            while (findSlot !=null){
//                if(findSlot.key == key){
//                    return findSlot.value;
//                }else{
//                    findSlot = findSlot.next;
//                }
//            }
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashRe myHashRe = new MyHashRe(20);
        myHashRe.saveData("DaveLee","01022223333");
        myHashRe.saveData("fun-coding","01033334444");
        myHashRe.saveData("David","01099998888");
        myHashRe.saveData("Dave","01055556666");
        myHashRe.saveData("DaveLee","01055556666");
        System.out.println(myHashRe.getData("fun-coding"));
        System.out.println(myHashRe.getData("David"));
    }

}
