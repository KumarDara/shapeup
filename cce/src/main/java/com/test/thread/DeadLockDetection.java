package com.test.thread;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.tools.attach.VirtualMachine;

public class DeadLockDetection {
	private static final String CONNECTOR_ADDRESS = "com.sun.management.jmxremote.localConnectorAddress";

	public static void main(String[] args) {
		try {
			detectDeadlock();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void detectDeadlock() throws Exception {
		// Get target's URL
		final JMXServiceURL target = getURLForPid("7284");

		// Connect to target (assuming no security)
		final JMXConnector connector = JMXConnectorFactory.connect(target);

		// Get an MBeanServerConnection on the remote VM.
		final MBeanServerConnection remote = connector.getMBeanServerConnection();

		final ThreadMXBean threadBean = ManagementFactory.newPlatformMXBeanProxy(remote,
				ManagementFactory.THREAD_MXBEAN_NAME, ThreadMXBean.class);
		
		//ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = threadBean.findDeadlockedThreads();
		int deadlockedThreads = threadIds != null ? threadIds.length : 0;
		System.out.println("Number of deadlocked threads: " + deadlockedThreads);
		for (long id : threadIds) {
			System.out.println("ThreadInfo::" + threadBean.getThreadInfo(id));
		}
	}

	private static JMXServiceURL getURLForPid(String pid) throws Exception {

		// attach to the target application
		final VirtualMachine vm = VirtualMachine.attach(pid);

		// get the connector address
		String connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);

		// no connector address, so we start the JMX agent
		if (connectorAddress == null) {
			String agent = vm.getSystemProperties().getProperty("java.home") + File.separator + "lib" + File.separator
					+ "management-agent.jar";
			vm.loadAgent(agent);

			// agent is started, get the connector address
			connectorAddress = vm.getAgentProperties().getProperty(CONNECTOR_ADDRESS);
			assert connectorAddress != null;
		}
		System.out.println("Connector address::"+connectorAddress);
		return new JMXServiceURL(connectorAddress);
	}
}
