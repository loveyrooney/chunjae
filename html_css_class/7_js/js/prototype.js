/*
생성자 함수는, Object를 상속해 사용자 원형 객체 프로토타입을 만들고 원형 객체를 참조한다.
인스턴스를 만들면 사용자 원형 객체 프로토타입을 복제해서 생성되는것.
인스턴스 메서드는 사용자 원형 객체 프로토타입에 선언하여야, 인스턴스들은 상속받아 사용.
(생성자 함수에 선언하면 인스턴스마다 메서드를 생성하게 되는 것)
인스턴스 정적 메서드는 사용자 원형 객체의 내장 메서드로, 인스턴스에 상속되지 않는다.

자바와의 차이점은 자바는 클래스 자체가 부모객체가 되고, 인스턴스는 클래스로부터 생성되는 것이다.
그래서 클래스에 인스턴스 메서드를 생성하면, 인스턴스는 상속받아 사용이 가능.
클래스를 만드는 순간 메모리에는 클래스를 위한 새로운 공간이 부여된다.
 */

let Man = function (name) {
    this.name=name;
}
Man.prototype.prt = function () {
    console.log('prototype method')
}

let man = new Man('hong');
console.dir(man);
console.log(Man.prototype);
console.log(Object.getPrototypeOf(man));