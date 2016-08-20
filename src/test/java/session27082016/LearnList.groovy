def list= ['Nam','Hoa','Dai','Linh','Hau']
////solution 1
//for(int i =0;i<list.size();i++){
//    println list.get(i)
//}


//Solution 2a
for(def name : list){
    println name
    if(name=='Hoa'){
        println 'found her!'
        break
    }
}
//solution 2b
for(def name : list){
    println name
    if(name!='Hoa')
        continue
    println 'found her!'
    break
}
////solution e3
//list.each {
//    println it
//}

//traverse