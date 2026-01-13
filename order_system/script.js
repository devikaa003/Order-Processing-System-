let pendingOrders = [];
let completedOrders = [];

function addOrder() {
  const id = document.getElementById("orderId").value;
  const name = document.getElementById("customerName").value;
  const type = document.getElementById("orderType").value;
  const items = document.getElementById("items").value.split(",").map(i => i.trim());

  if (!id || !name || items.length === 0) {
    alert("Please fill all fields!");
    return;
  }

  const order = {
    orderId: parseInt(id),
    customerName: name,
    orderType: type,
    items,
    timestamp: Date.now()
  };

  pendingOrders.push(order);
  document.getElementById("output").innerText = `✅ Order ${id} added (${type})`;
  clearInputs();
}

function processNextOrder() {
  if (pendingOrders.length === 0) {
    document.getElementById("output").innerText = "⚠️ No orders to process.";
    return;
  }

  // Priority: PRIME > NORMAL
  pendingOrders.sort((a, b) => {
    if (a.orderType === b.orderType) return a.timestamp - b.timestamp;
    return a.orderType === "PRIME" ? -1 : 1;
  });

  const next = pendingOrders.shift();
  completedOrders.push(next);
  document.getElementById("output").innerText = `🚚 Processed Order ${next.orderId} (${next.customerName}) ✅`;
}

function viewPending() {
  if (pendingOrders.length === 0) {
    document.getElementById("output").innerText = "No pending orders.";
    return;
  }
  let text = "📋 Pending Orders:\n";
  pendingOrders.forEach(o => {
    text += ` - ${o.orderId} | ${o.customerName} | ${o.orderType}\n`;
  });
  document.getElementById("output").innerText = text;
}

function viewCompleted() {
  if (completedOrders.length === 0) {
    document.getElementById("output").innerText = "No completed orders yet.";
    return;
  }
  let text = "✅ Completed Orders (most recent first):\n";
  [...completedOrders].reverse().forEach(o => {
    text += ` - ${o.orderId} | ${o.customerName} | ${o.orderType}\n`;
  });
  document.getElementById("output").innerText = text;
}

function clearInputs() {
  document.getElementById("orderId").value = "";
  document.getElementById("customerName").value = "";
  document.getElementById("items").value = "";
}
