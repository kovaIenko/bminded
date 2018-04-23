var LevelAchieved =
    {
        preload: function () {
            game.load.image('LevelAchieved', '../static/Backgrounds/LevelAchieved.png');
            game.load.image('background', '../static/Backgrounds/orig.jpg');
            game.load.image('Continue', '../static/Backgrounds/Contin.png');
            game.load.image('downPanel', '../static/Backgrounds/downPanel.png');

        },
        create : function () {
            game.add.sprite(0,0,'background');
            game.add.sprite(117,124,'LevelAchieved');
            var button = game.add.button(225, 300, 'Continue', actionOnClick, this);
            game.add.sprite(0,491,'downPanel');
            game.add.text(300,488,level,{font:'30px Furore',fill:"#525055"});
            game.add.text(390,488,tries,{font:'30px Furore',fill:"#525055"});
            game.add.text(370,205,level,{font:'30px Furore',fill:"#525055"});
            game.add.text(370,240,pointsForlevel[level-1],{font:'30px Furore',fill:"#525055"});
            game.add.text(420,488,"| Game Points " + gamePoint,{font:'25px Furore',fill:"#525055"});


        },
        start: function () {
        }
    };

function actionOnClick () {
    game.state.start('menu');
}