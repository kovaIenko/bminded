var LevelFailed0tries =
    {
        preload: function () {
            game.load.image('LevelFailed0tries', 'src/main/resources/static/Backgrounds/LevelFailed0tries.png');
            game.load.image('background', 'src/main/resources/static/Backgrounds/orig.jpg');
            game.load.image('Continue', 'src/main/resources/static/Backgrounds/Contin.png');
            game.load.image('downPanel', 'src/main/resources/static/Backgrounds/downPanel.png');

        },
        create : function () {
            game.add.sprite(0,0,'background');
            game.add.sprite(117,124,'LevelFailed0tries');
            var button = game.add.button(225, 300, 'Continue', actionOnClick1, this);
            game.add.sprite(0,491,'downPanel');
            game.add.text(300,488,level,{font:'30px Furore',fill:"#525055"});
            game.add.text(390,488,tries,{font:'30px Furore',fill:"#525055"});
            game.add.text(420,488,"| Game Points " + gamePoint,{font:'25px Furore',fill:"#525055"});

        },
        start: function () {
        }
    };

function actionOnClick1 () {
    game.state.start('menu');
    tries = 3;
    if(level > 1) {
        level -= 1;

    }
}