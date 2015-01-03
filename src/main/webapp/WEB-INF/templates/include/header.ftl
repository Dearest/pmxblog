
   <header class="navbar navbar-fixed-top">
    <section class="title">
        <div class="container">
            <div class="row-fluid">
                <div class="span6">
                    <h3>博客</h3>
                </div>
                <div class="span6">
                    <ul class="breadcrumb pull-right">
                       <#if loginAdmin??>
                        <li>
                            <h5>欢迎你 ，${loginAdmin.name}</h5><span class="divider">/</span>
                        </li>
                        <li class="login">
                            <a  href="add"><h5>发布文章</h5></a>
                        </li>
                        <#else>
                        <li class="login">
                            <a href="user/login"><h5>登录</h5></a>
                        </li>
                        </#if>
                       
                    </ul>
                </div>
            </div>
        </div>
    </section>
    </header>