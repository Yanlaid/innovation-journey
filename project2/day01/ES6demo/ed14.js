class Animal {
    constructor(name) {
        this.name = name;
    }

    sayName() {
        console.log('name is ' + this.name)
    }
}

class people extends Animal{
    constructor(name){
        super(name);
    }
    program(){
        console.log("im coding")
    }
}

let animal = new Animal('shen');
let people1 = new people("sb");
animal.sayName();
people1.sayName();
people1.program();