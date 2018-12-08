const person = {
    name: 'shenxinran',
    age: 21,
    language: ['java', 'go', 'python']
};
let {
    name,
    age,
    language
} = person;
console.log(name);
console.log(age);
let [x, y, z] = language;
console.log(x, y, z);