//todo ...用来组装数组与对象
let a1 = ['a', 'b'];
let a2 = [...a1, 'e', '5'];
console.log(a2);

let b1 = {name: 'shen', age: 21};
let b2 = {...b1,salary:15000, address: '上海'};
console.log(b2);

