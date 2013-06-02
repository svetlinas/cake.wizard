$('document').ready(function(){

    function _$(id){
        return document.getElementById(id);
    }

    $.fn.pager = function(container, number){
        if(_$('pager')){
            container.removeChild(_$('pager'));
        }

        var pager = document.createElement('div');
        pager.id = 'pager';
        if(number <= 5){
            pager.style.width = number*30 + 'px';
        }else{
            pager.style.width = 9*30 + 'px';
        }


        this.action;
        this.container = container;
        this.number = number;

        this.events = function(){
            var nodes = pager.getElementsByTagName('div');
            var repage = this.repage;
            var action = this.action;

            var getPos = function(){
                for(var i=0 ; i < nodes.length ; i++){
                    if(nodes[i].className == 'selected'){
                        return parseInt(nodes[i].innerHTML);
                    }
                }
            }

            var number = this.number;

            if(number <= 5){
                for(var i=0 ; i < number ; i++){
                    nodes[i].onclick = function(){
                        repage(getPos(), parseInt(this.innerHTML, 10), action);
                    }
                }
                return;
            }

            nodes[0].onclick = function(){
                repage(getPos(), 1, action);
            }

            nodes[1].onclick = function(){
                var pos = getPos();
                if(pos <= 1)return;
                repage(pos, pos-1, action);
            }

            nodes[nodes.length-1].onclick = function(){
                repage(getPos(), number, action);
            }

            nodes[nodes.length-2].onclick = function(){
                var pos = getPos();
                if(pos >= number)return;
                repage(pos, pos+1, action);
            }

            for(var i=2 ; i < nodes.length-2 ; i++){
                nodes[i].onclick = function(){
                    repage(getPos(), parseInt(this.innerHTML), action);
                }
            }
        }

        this.repage = function(current, position, action){
            if(interval != null)return;
            var nodes = pager.getElementsByTagName('div');

            if(nodes.length <= 5){
                for(var i=0; i < nodes.length ; i++){
                    if(i == position-1)nodes[i].className = 'selected';
                    else nodes[i].className = '';
                    nodes[i].innerHTML = i+1;
                }
                action(current, position);
                return;
            }

            var num;
            if(position <= 3){
                num = 1;
            }else if(number - position < 2){
                num = number - 4;
            }else{
                num = position - 2;
            }

            for(var i=2; i < nodes.length-2 ; i++, num++){
                if(num == position)nodes[i].className = 'selected';
                else nodes[i].className = '';
                nodes[i].innerHTML = num;
            }

            if(this.number <= 5){
                nodes[0].className += ' disabled';
                nodes[1].className += ' disabled';
                nodes[nodes.length-2].className += ' disabled';
                nodes[nodes.length-1].className += ' disabled';
            }else if(position <= 3){
                if(position == 1){
                    nodes[1].className += ' disabled';
                }else{
                    nodes[1].className = nodes[1].className.split(' ')[0];
                }
                nodes[0].className += ' disabled';
                nodes[nodes.length-2].className = nodes[nodes.length-2].className.split(' ')[0];
                nodes[nodes.length-1].className = nodes[nodes.length-1].className.split(' ')[0];
            }else if(position >= number - 2){
                if(position == number){
                    nodes[nodes.length-2].className += ' disabled';
                }else{
                    nodes[nodes.length-2].className = nodes[nodes.length-2].className.split(' ')[0];
                }
                nodes[nodes.length-1].className += ' disabled';
                nodes[0].className = nodes[0].className.split(' ')[0];
                nodes[1].className = nodes[1].className.split(' ')[0];
            }else{
                nodes[0].className = nodes[0].className.split(' ')[0];
                nodes[1].className = nodes[1].className.split(' ')[0];
                nodes[nodes.length-2].className = nodes[nodes.length-2].className.split(' ')[0];
                nodes[nodes.length-1].className = nodes[nodes.length-1].className.split(' ')[0];
            }
            action(current, position);

        }

        this.init = function(pageNumber){
            if(this.number <= 5){
                for(var i=0 ; i < this.number ; i++){
                    var node = document.createElement('div');
                    pager.appendChild(node);
                }
                this.container.appendChild(pager);

                this.events();
                this.repage(1,1,this.action);
                return;
            }

            for(var i=0 ; i < 9 ; i++){
                var node = document.createElement('div');
                pager.appendChild(node);
                switch (i){
                    case 0:
                        node.className = 'first';
                        break;
                    case 1:
                        node.className = 'prev';
                        break;
                    case 7:
                        node.className = 'next';
                        break;
                    case 8:
                        node.className = 'last';
                    default:
                }
            }
            this.container.appendChild(pager);
            this.events();
            this.repage(pageNumber,pageNumber,this.action);
        }

    }
})