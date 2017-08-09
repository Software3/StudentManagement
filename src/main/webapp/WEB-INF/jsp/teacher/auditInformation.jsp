<%--
  Created by IntelliJ IDEA.
  User: 51157
  Date: 2017/8/9
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/teacIncludeTop.jsp" %>
<div id="pad-wrapper">
    <div class="row">
        <div class="col-md-12 col-xs-12">
            <div id="fuelux-wizard" class="wizard row">
                <ul class="wizard-steps">
                    <li data-target="#step1" class="active">
                        <span class="step">1</span>
                        <span class="title">General <br> information</span>
                    </li>
                    <li data-target="#step2">
                        <span class="step">2</span>
                        <span class="title">Address <br> information</span>
                    </li>
                    <li data-target="#step3">
                        <span class="step">3</span>
                        <span class="title">User <br> settings</span>
                    </li>
                    <li data-target="#step4">
                        <span class="step">4</span>
                        <span class="title">Payment <br> info</span>
                    </li>
                </ul>
            </div>
            <div class="step-content">
                <div class="step-pane active" id="step1">
                    <div class="row form-wrapper">
                        <div class="col-md-8">
                            <form>
                                <div class="field-box">
                                    <label>Name:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box error">
                                    <label>Company:</label>
                                    <input class="form-control" type="text" />
                                    <span class="alert-msg"><i class="icon-remove-sign"></i> Please enter your company</span>
                                </div>
                                <div class="field-box">
                                    <label>Email:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box success">
                                    <label>Username:</label>
                                    <input class="form-control" type="text" />
                                    <span class="alert-msg"><i class="icon-ok-sign"></i> Username available</span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step2">
                    <div class="row form-wrapper">
                        <div class="col-md-8">
                            <form>
                                <div class="field-box">
                                    <label>Address:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>City:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>Postal/ZIP code:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>Country:</label>
                                    <input class="form-control" type="text" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step3">
                    <div class="row form-wrapper">
                        <div class="col-md-8">
                            <form>
                                <div class="field-box">
                                    <label>Username:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>Photo:</label>
                                    <input type="file" />
                                </div>
                                <div class="field-box">
                                    <label>App name:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>Time zone:</label>
                                    <select>
                                        <option value="Hawaii">(GMT-10:00) Hawaii</option>
                                        <option value="Alaska">(GMT-09:00) Alaska</option>
                                        <option value="Pacific Time (US &amp; Canada)">(GMT-08:00) Pacific Time (US &amp; Canada)</option>
                                        <option value="Arizona">(GMT-07:00) Arizona</option>
                                        <option value="Mountain Time (US &amp; Canada)">(GMT-07:00) Mountain Time (US &amp; Canada)</option>
                                        <option value="Central Time (US &amp; Canada)">(GMT-06:00) Central Time (US &amp; Canada)</option>
                                        <option value="Eastern Time (US &amp; Canada)">(GMT-05:00) Eastern Time (US &amp; Canada)</option>
                                        <option value="Indiana (East)">(GMT-05:00) Indiana (East)</option><option value="" disabled="disabled">-------------</option>
                                        <option value="American Samoa">(GMT-11:00) American Samoa</option>
                                        <option value="International Date Line West">(GMT-11:00) International Date Line West</option>
                                        <option value="Midway Island">(GMT-11:00) Midway Island</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step4">
                    <div class="row form-wrapper payment-info">
                        <div class="col-md-8">
                            <form>
                                <div class="field-box">
                                    <label>Subscription Plan:</label>
                                    <select id="plan">
                                        <option value="66">Basic - $2.99/month (USD)</option>
                                        <option value="67">Pro - $9.99/month (USD)</option>
                                        <option value="68">Premium - $49.99/month (USD)</option>
                                    </select>
                                </div>
                                <div class="field-box">
                                    <label>Credit Card Number:</label>
                                    <input class="form-control" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>Expiration:</label>
                                    <input class="form-control" style="width:60px;display:inline" placeholder="MM" type="text" />
                                    &nbsp; / &nbsp;
                                    <input class="form-control" style="width:85px;display:inline" placeholder="YYYY" type="text" />
                                </div>
                                <div class="field-box">
                                    <label>Card CVC Number:</label>
                                    <input class="form-control" type="text" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wizard-actions">
                <button type="button" disabled class="btn-glow primary btn-prev">
                    <i class="icon-chevron-left"></i> Prev
                </button>
                <button type="button" class="btn-glow primary btn-next" data-last="Finish">
                    Next <i class="icon-chevron-right"></i>
                </button>
                <button type="button" class="btn-glow success btn-finish">
                    Setup your account!
                </button>
            </div>
        </div>
    </div>
</div>
</div>
<!-- end main container -->

<!-- scripts for this page -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/fuelux.wizard.js"></script>

<script type="text/javascript">
    $(function () {
        var $wizard = $('#fuelux-wizard'),
            $btnPrev = $('.wizard-actions .btn-prev'),
            $btnNext = $('.wizard-actions .btn-next'),
            $btnFinish = $(".wizard-actions .btn-finish");

        $wizard.wizard().on('finished', function(e) {
            // wizard complete code
        }).on("changed", function(e) {
            var step = $wizard.wizard("selectedItem");
            // reset states
            $btnNext.removeAttr("disabled");
            $btnPrev.removeAttr("disabled");
            $btnNext.show();
            $btnFinish.hide();

            if (step.step === 1) {
                $btnPrev.attr("disabled", "disabled");
            } else if (step.step === 4) {
                $btnNext.hide();
                $btnFinish.show();
            }
        });

        $btnPrev.on('click', function() {
            $wizard.wizard('previous');
        });
        $btnNext.on('click', function() {
            $wizard.wizard('next');
        });
    });
</script>
</body>
</html>