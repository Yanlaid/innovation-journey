let promise = new Promise(function (resolve, reject) {
    setTimeout(()=>{
        var number = Math.random();
        if (number < 0.5) {
            resolve("成功 " + number);
        }else{
            reject("失败 " + number);
        }

    },300)
});
promise.then(value => console.log(value)).catch(value => console.log(value));