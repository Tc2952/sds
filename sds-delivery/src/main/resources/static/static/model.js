var init = function () {


    http.get('/admin/view', '加载数据...', function (res) {

        var list = $("#list");
        list.empty();

        var nodes = res.nodes;
        var total = res.total;
        $("#total").text('在线量:'+total);

        for (var p in nodes) {
            var v = nodes[p];
            var tr = '<tr>' +
                '<td><a class="model-name" data-model="' + v.model +'" href="#">' + v.model +'('+v.size+')</a></td>' +
                '</tr>';
            list.append(tr);
        }

    });
};


init();


$(document).on("click", ".model-name", function () {
    var key = $(this).attr("data-model");

    http.get('/admin/connections?key=' + key, '加载数据...', function (res) {

        var list = $("#device");
        list.empty();
        for (var p in res) {
            var data = res[p];
            var tr = '<tr><td><a  href="#">' + data + '</a></td></tr>';
            list.append(tr);
        }

    });

    return false;
});

