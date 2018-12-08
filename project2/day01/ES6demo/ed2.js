function mp(boo) {

    /*let const 均是块级元素*/
    if (boo) {
        let ff = 'aaa';
    } else {
        console.log(ff);
    }
}

mp(false);
