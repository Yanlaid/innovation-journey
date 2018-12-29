let Mock = require('mockjs')
let data = Mock.mock({
    'list|5':[
        {
            "id|+1":1,
            "name":"@cname"
        }
    ]
})
console.log(data);