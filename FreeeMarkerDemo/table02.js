

var allCells = $("td, th");

allCells
  .on("mouseover", function() {
    var el = $(this),
        pos = el.index();
    el.parent().find("th, td").addClass("hover");
    allCells.filter(":nth-child(" + (pos+1) + ")").addClass("hover");
  })
  .on("mouseout", function() {
    allCells.removeClass("hover");
  });

