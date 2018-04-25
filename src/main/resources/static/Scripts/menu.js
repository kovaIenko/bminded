var menuState =
    {
        preload: function () {
            game.load.image('MenuImg', '/Backgrounds/Menu2.png');
            game.load.image('background', '/Backgrounds/orig.jpg');
            game.load.image('Continue', '/Backgrounds/Contin.png');
            game.load.image('downPanel', '/Backgrounds/downPanel.png');

// PauseMenu

            //game.state.start('menu');
        },
        create : function () {
            game.add.sprite(0,0,'background');
            game.add.sprite(117,124,'MenuImg');
            var button = game.add.button(225, 300, 'Continue', actionOnClick, this);
            game.add.text(250,520,"You have "+ tries+" try(ies) " ,{font:'25px Monotype Corsiva',fill:"#62C908"});
            game.add.sprite(0,491,'downPanel');
            game.add.text(300,488,level,{font:'30px Furore',fill:"#525055"});
            game.add.text(390,488,tries,{font:'30px Furore',fill:"#525055"});
            game.add.text(370,145,level,{font:'35px Furore',fill:"#525055"});
            game.add.text(370,207,firefliesAtBegining[level],{font:'25px Furore',fill:"#525055"});
            game.add.text(370,240,wathcingTime[level]/1000,{font:'25px Furore',fill:"#525055"});
            game.add.text(420,488,"| Game Points " + gamePoint,{font:'25px Furore',fill:"#525055"});


        },
        start: function () {
        }
    };
var tries = 3;
function actionOnClick () {
    game.state.start('play');
}