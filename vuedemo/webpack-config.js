/*TODO 首行声明插件的引用*/
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
    entry: './vue-router/main.js',
    output: {
        path: __dirname + "/dist",  /*TODO 指定输出的目录*/
        filename: "build.js" /*TODO 指定输出的文件名*/
    },
    module: {
        rules: [
            {
                test: /\.css$/, // 通过正则表达式匹配所有以.css后缀的文件
                use: [ // 要使用的加载器，这两个顺序一定不要乱
                    'style-loader',
                    'css-loader'
                ]
            }
        ]
    },
    /*TODO html插件的使用*/
    plugins:[
        new HtmlWebpackPlugin({
            title: '首席',  //生成的页面标题<head><title>首页</title></head>
            filename: 'index.html', // dist目录下生成的文件名
            template: './vue-router/index.html' // 我们原来的index.html，作为模板
        })
    ]
}
