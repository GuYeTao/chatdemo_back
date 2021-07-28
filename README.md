# chatdemo_back

这是一个开发了十天左右的前后端分离项目,这里是后端,对应的项目前端在chatdemo_front中.

开发环境及工具:Window10,VSCode,IDEA

前端框架vue2.9.6

后端框架Springboot

数据库:mysql5.7.22

持久层框架:mybatis2.2.0

组件库element UI

Jdk 1.8

JAVA 8



主要功能:

## 1.电商平台中由购物车中选择商品生成订单:

将数据库中关于当前用户的购物车条目分页显示,显示信息包括商品图片,商品名,单价,数量.

商品总价由前端通过计算得出,带有的操作是删除,增加和减少商品数量,其中减少不可小于1,增加不能大于商家库存.

通过选择框选择购买的商品,(不选择商品无法提交订单),在弹出的对话框中选择当前用户的收货地址,点击提交订单,生成订单表项,关系表项,删除购物车中选择的商品,修改商品的库存和销量.

## 2.查看用户订单,对用户订单进行查看详情,支付,查看对应运单:

将数据库中关于当前用户的订单分页显示,能够通过订单id,状态,时间组合查询,通过不同状态的判断,显示不同的订单操作,其中所有订单都有详情,未支付的订单显示支付,已发货的订单显示运单.

将当前订单的详细商品信息展示出来,并通过判断商品是否已评价,显示评价操作.

将当前订单的总价计算并展示,选择支付方式,如果选择会员卡支付,会先行判断会员卡中余额是否足够支付,如果足够支付就会扣除相应金额,修改订单状态,生成支付表项.

## 3.查看运单详情,查看物流地图:

将当前用户的运单分页显示,能够通过运单id,订单id,运单状态组合查询,通过判断运单是否发货显示物流按钮.

点击'详情'将当前用运单包含的商品进行展示,点击'物流',查看商品运送线路(调用百度地图)

## 4.用户与商家进行一对一聊天,支持多对用户商家同时聊天,支持聊天的常见消息操作(最先做的,所以整个项目名是chatdemo):

基于websocket的网页聊天,实现用户与商家的一对一聊天,可以同时进行多组聊天,聊天窗口中有三种消息,自己消息,对方消息,系统推送,能够对自己消息进行删除(自己看不到,对方能看到),撤回(时间内撤回,双方都看不到),能够查看聊天历史记录.

查看历史记录能够通过用户id,消息关键字进行组合搜索消息记录.

前端:

撤回的实现:撤回需要双向删除,采用点击撤回时再次发送一条消息,(带有特殊标记),接受方接受到就会知道这是一条撤回的信号,删除消息列表中的信息后,在数据库中删除该条数据.

定位:通过chatId反向找到需要撤回的消息在列表中的index(聊天双方的消息列表并不等长).

删除的实现:删除消息仅能让自己看不到,对方仍旧能够看到,并且这种状态是持久的,将删除理解为消息标志位的更新,只让删除者看不到,查不到该条消息,数据库中仍旧保存该条数据.

后端:

Onopen:通过用户权限判断聊天的加入者是用户还是商家,如果用户先登录,则会将用户排进用户等待队列,并向用户推送系统信息,,如果用户后登录,则取出在商家等待队列中的商家建立聊天对(用于实现用户商家一对一聊天,多人情况下,消息不会发送给其他人)

OnMessage:通过接受到的消息判断聊天双方,取出聊天双方的session,进行消息发送,实现聊天的主要功能,消息的接受与发送.
