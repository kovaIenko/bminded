var StartScreen =
    {
        preload: function () {
            game.load.image('StartScreen', 'src/main/resources/static/Backgrounds/StartScreen.png');
            game.load.image('BeginButton', 'src/main/resources/static/Backgrounds/BeginButton.png');
        },
        create : function () {
            game.add.sprite(-1,-1,'StartScreen');
            var button = game.add.button(225, 470, 'BeginButton', actOnClick, this);
         },
        start: function () {
        }
    };

function actOnClick () {
    game.state.start('menu');
}