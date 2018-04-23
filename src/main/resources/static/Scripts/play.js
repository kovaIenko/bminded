var boolTimer = false;
var group;
var timer;
var additionalTimer;
var additionalGroup;
var timerForPauseBeforeStartFailedMenu;
var level  = 1;
var wathcingTime = [7000,10000,11000,13000,14000,13000,14000,16000,15000,16000,18000,17000,19000,20000,25000,28000];
var firefliesAtBegining = [1,2,3,3,4,4,5,6,6,7,7,8,8,8,9,9];
var firefliesAdditional = [3,3,4,4,5,5,6,6,7,7,6,6,5,5,5,5];
var pointsForlevel = [10,30,60,100,150,200,220,250,300,320,350,400,500,600,700,1000];
var check = 0;
var gamePoint = 0;
var playState =
{

    preload: function () {
        game.load.image('MenuImg', 'src/main/resources/static/Backgrounds/Menu2.png');
        game.load.image('background', 'src/main/resources/static/Backgrounds/orig.jpg');
        game.load.image('Continue', 'src/main/resources/static/Backgrounds/Contin.png');
        game.load.image('firefly', 'src/main/resources/static/Backgrounds/FireFly.png');
        game.load.image('fireflyWorng', 'src/main/resources/static/Backgrounds/FireFlyWrong.png');
        game.load.image('downPanel', 'src/main/resources/static/Backgrounds/downPanel.png');

    },
    create: function () {

        gamepoints();

        game.add.sprite(0,0,'background');
        game.add.sprite(0,491,'downPanel');
        game.add.text(300,488,level,{font:'30px Furore',fill:"#525055"});
        game.add.text(390,488,tries,{font:'30px Furore',fill:"#525055"});
        game.add.text(420,488,"| Game Points " + gamePoint,{font:'25px Furore',fill:"#525055"});


        game.world.setBounds(0,0, 650, 491);
        game.physics.startSystem(Phaser.Physics.P2JS);
        game.stage.backgroundColor = '#124184';
        game.physics.p2.gravity.y = 0;
        game.physics.p2.restitution = 1.0;
        game.physics.p2.frameRate = 1/500;

        createBeginingFireFlies();

        timer = game.time.create(false);
        timer.loop(5000, updateCounter, this);
        timer.start();

        additionalTimer = game.time.create(false);
        additionalTimer.loop(wathcingTime[level], updateAdditionalCounter, this);
        game.inputEnabled = false;

    }

}

function createBeginingFireFlies() {
    group = game.add.physicsGroup(Phaser.Physics.P2JS);
    group.inputEnableChildren = true;
    for (var i = 0; i < firefliesAtBegining[level]; i++)
    {
        var ball = group.create(game.world.randomX,game.world.randomY, 'firefly');
        ball.body.velocity.x = 400;
        ball.body.velocity.y = 400;
        ball.body.setCircle(16);
        ball.body.fixedRotation = true;
        ball.name = 'firelfy'+ (i+1);

    }

}

function update () {
 if(group.body.velocity.x < 80)
    {
        ball.body.velocity.x = 80;
    }
    if(ball.body.velocity.y < 80)
    {
        ball.body.velocity.y = 80;
    }
   game.physics.arcade.collide(group, group);


}
function updateCounter() {
    timer.stop();
    boolTimer = true;
    additionalGroup = game.add.physicsGroup(Phaser.Physics.P2JS);
    additionalGroup.inputEnableChildren = true;
    for (var i = 0; i < firefliesAdditional[level]; i++)
    {
        var ball = additionalGroup.create(game.world.randomX,game.world.randomY, 'firefly');
        ball.body.velocity.x = 400;
        ball.body.velocity.y = 400;
        ball.body.setCircle(16);
        ball.body.fixedRotation = true;
        ball.name = 'notfirefly';

    }
    additionalTimer.start();
}
function updateAdditionalCounter() {
    additionalTimer.stop();
    group.onChildInputDown.add(clickedSprite, this);
    additionalGroup.onChildInputDown.add(clickedSprite, this);
    additionalGroup.forEach(function (ball) {
        ball.body.velocity.x = 0;
        ball.body.velocity.y = 0;
    });
    group.forEach(function (ball) {
        ball.body.velocity.x = 0;
        ball.body.velocity.y = 0;
    });

}
function clickedSprite (sprite) {


    if(sprite.name != ('notfirefly')){
        sprite.kill();
        check+=1;
        if(check == firefliesAtBegining[level])
        {
            timerForPauseBeforeStartFailedMenu = game.time.create(false);
            timerForPauseBeforeStartFailedMenu.loop(1000, loadAchivedMenu, this);
            timerForPauseBeforeStartFailedMenu.start();

        }
    }
    else {
        circle = new Phaser.Circle(sprite.position.x, sprite.position.y,50);
        game.debug.geom(circle,'rgba(255,0,0,0.2)');
       tries-=1;
        timerForPauseBeforeStartFailedMenu = game.time.create(false);
        timerForPauseBeforeStartFailedMenu.loop(1000, loadFailMenu, this);
        timerForPauseBeforeStartFailedMenu.start();
        console.log(tries);

    }

}

function loadFailMenu() {
    timerForPauseBeforeStartFailedMenu.stop();

    if( tries > 0) {
        game.state.start('LevelFailedTries');
    }else{
        tries = 3;
        game.state.start('LevelFailed0Tries');
    }
}

function loadAchivedMenu() {
    check = 0;
    level+=1;
    game.state.start('LevelAchieved');
}

function gamepoints() {
    gamePoint =0;
    for (var i = 0; i < level -1 ; i++ )
    {
        gamePoint += pointsForlevel[i];
    }
}