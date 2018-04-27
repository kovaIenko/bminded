
    var game = new Phaser.Game(
        650,
        520,
        Phaser.AUTO,
        'game'
    );
    game.state.add('startScreen', StartScreen, false);
    game.state.add('LevelAchieved', LevelAchieved, false);
    game.state.add('LevelFailed0Tries', LevelFailed0tries, false);
    game.state.add('LevelFailedTries', LevelFailedtries, false);
    game.state.add('menu', menuState, false);
    game.state.add('play', playState, false);
    game.state.start('startScreen');


