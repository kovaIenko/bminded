var StartScreen =
    {
        preload: function () {
            game.load.image('StartScreen', '/Backgrounds/StartScreen.png');
            game.load.image('BeginButton', '/Backgrounds/BeginButton.png');
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